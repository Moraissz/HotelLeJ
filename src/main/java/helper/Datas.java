package helper;

import java.time.LocalDate;
import java.time.Period;

public class Datas 
{
	public static boolean comparardatas (LocalDate datahoje, LocalDate datasaida, LocalDate comparacao1, LocalDate comparacao2)
	{
		boolean estado = true;
		
		Period periodo = Period.between(comparacao1, comparacao2); //data saida é exclusivo
		
		int tamanho = periodo.getDays();
		
		for(int i=0;i<=tamanho;i=i+1)
		{
			System.out.println("DATA:  "    +comparacao1);
			System.out.println("ALOOOO" +datahoje);
			if(comparacao1.isEqual(datahoje) || comparacao1.isEqual(datasaida))
			{
				
				
				estado=false;
				break;
			}
			comparacao1 = comparacao1.plusDays(1);
		}
		System.out.println("NÃO PODE:   "+comparacao2);
		System.out.println("\n\n\n");
		return estado;
	}
}
