package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.PolizaDTO;
import cl.cesarquezada.proyecto.entity.Poliza;
import org.springframework.stereotype.Component;

@Component
public class PolizaMapper {

    public PolizaDTO toDTO(Poliza poliza) {
        if (poliza == null) {
            return null;
        }
        PolizaDTO dto = new PolizaDTO();
        dto.setId(poliza.getId());
        dto.setNumeroPoliza(poliza.getNumeroPoliza());
        dto.setRamo(poliza.getRamo());
        dto.setCliente(poliza.getCliente());
        dto.setFechaEfecto(poliza.getFechaEfecto());
        dto.setPrima(poliza.getPrima());
        dto.setEstado(poliza.getEstado());
        dto.setActivo(poliza.getActivo());
        dto.setFechaCreacion(poliza.getFechaCreacion());
        dto.setFechaModificacion(poliza.getFechaModificacion());
        return dto;
    }

    public Poliza toEntity(PolizaDTO dto) {
        if (dto == null) {
            return null;
        }
        Poliza poliza = new Poliza();
        poliza.setId(dto.getId());
        poliza.setNumeroPoliza(dto.getNumeroPoliza());
        poliza.setRamo(dto.getRamo());
        poliza.setCliente(dto.getCliente());
        poliza.setFechaEfecto(dto.getFechaEfecto());
        poliza.setPrima(dto.getPrima());
        poliza.setEstado(dto.getEstado());
        poliza.setActivo(dto.getActivo());
        poliza.setFechaCreacion(dto.getFechaCreacion());
        poliza.setFechaModificacion(dto.getFechaModificacion());
        return poliza;
    }
}
