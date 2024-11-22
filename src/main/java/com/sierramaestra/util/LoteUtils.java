package com.sierramaestra.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sierramaestra.dto.LoteCervezaDTO;
import com.sierramaestra.model.Cerveza;
import com.sierramaestra.model.Lote;

@Component
public class LoteUtils {
	public static List<LoteCervezaDTO> loteMapper(List<Lote> lotes, Cerveza cervezaId){
		List<LoteCervezaDTO> loteCervezaDtos = new ArrayList<>();
		for(Lote lote : lotes) {
			loteCervezaDtos.add(new LoteCervezaDTO(lote.getCerveza(),lote.getCantidadLitros(),lote.getEstado(),lote.getFechaVencimiento()));
		}
		return loteCervezaDtos;
	} 
	 

}

/*@Component
public class FlightUtils {
    public List<FlightDto> flightMapper(List<Flight> flights, double dollarPrice){
        List <FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights){
            flightDtos.add(new FlightDto(flight.getId(),flight.getOrigin(),flight.getDestiny(),flight.getDateTimeDeparture(),
                    flight.getDateTimeArrival(),flight.getPrice() * dollarPrice,flight.getFrequency(), flight.getCompany()));
        }
        return flightDtos;
    }*/
