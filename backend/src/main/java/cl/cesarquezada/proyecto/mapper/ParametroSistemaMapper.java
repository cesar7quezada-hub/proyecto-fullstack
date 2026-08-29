package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.ParametroSistemaDTO;
import cl.cesarquezada.proyecto.entity.ParametroSistema;
import org.springframework.stereotype.Component;

@Component
public class ParametroSistemaMapper {

    public ParametroSistemaDTO toDTO(ParametroSistema parametroSistema) {
        if (parametroSistema == null) return null;
        ParametroSistemaDTO dto = new ParametroSistemaDTO();
        dto.setId(parametroSistema.getId());
        dto.setCodigo(parametroSistema.getCodigo());
        dto.setNombre(parametroSistema.getNombre());
        dto.setValor(parametroSistema.getValor());
        dto.setTipoDato(parametroSistema.getTipoDato());
        dto.setDescripcion(parametroSistema.getDescripcion());
        dto.setEditable(parametroSistema.getEditable());
        dto.setActivo(parametroSistema.getActivo());
        dto.setFechaCreacion(parametroSistema.getFechaCreacion());
        dto.setFechaModificacion(parametroSistema.getFechaModificacion());
        return dto;
    }

    public ParametroSistema toEntity(ParametroSistemaDTO dto) {
        if (dto == null) return null;
        ParametroSistema parametroSistema = new ParametroSistema();
        parametroSistema.setId(dto.getId());
        parametroSistema.setCodigo(dto.getCodigo());
        parametroSistema.setNombre(dto.getNombre());
        parametroSistema.setValor(dto.getValor());
        parametroSistema.setTipoDato(dto.getTipoDato());
        parametroSistema.setDescripcion(dto.getDescripcion());
        parametroSistema.setEditable(dto.getEditable());
        parametroSistema.setActivo(dto.getActivo());
        parametroSistema.setFechaCreacion(dto.getFechaCreacion());
        parametroSistema.setFechaModificacion(dto.getFechaModificacion());
        return parametroSistema;
    }
}
