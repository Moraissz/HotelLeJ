package helper;

import java.time.LocalDate;
import java.time.Period;

public class Datas 
{
	public static boolean comparardatas (LocalDate datahoje, LocalDate datasaida, LocalDate comparacao1, LocalDate comparacao2)
	{
		boolean estado = true;
		
		Period periodo = Period.between(datahoje, datasaida.plusDays(1)); //data saida é exclusivo
		
		int tamanho = periodo.getDays();
		
		for(int i=0;i<tamanho;i=i+1)
		{
			if(datahoje.isEqual(comparacao1) || datahoje.isEqual(comparacao2) || datasaida.isEqual(comparacao1) || datasaida.isEqual(comparacao2))
			{
				System.out.println("ALOOOO" +datahoje);
				datahoje.plusDays(1);
				
				estado=false;
				break;
			}
			datahoje = datahoje.plusDays(1);
		}
		return estado;
	}
}
