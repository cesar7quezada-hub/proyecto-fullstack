$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$BackendDir = Join-Path $ScriptDir "..\backend"
$EnvFile = Join-Path $BackendDir ".env"

if (-not (Test-Path $EnvFile)) {
    Write-Error "No existe $EnvFile. Crea uno con DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD."
    exit 1
}

Get-Content $EnvFile | ForEach-Object {
    if ($_ -match '^\s*([^#=]+)=(.*)$') {
        $name = $matches[1].Trim()
        $value = $matches[2].Trim()
        Set-Item -Path "Env:$name" -Value $value
    }
}

Set-Location $BackendDir
$profile = if ($env:SPRING_PROFILES_ACTIVE) { $env:SPRING_PROFILES_ACTIVE } else { "local" }
& .\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=$profile"
