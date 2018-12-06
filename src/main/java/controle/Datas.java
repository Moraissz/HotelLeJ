package controle;

import java.time.LocalDate;
import java.time.Period;

public class Datas 
{
	public static boolean comparardatas (LocalDate datahoje, LocalDate datasaida, LocalDate comparacao1, LocalDate comparacao2)
	{
		boolean estado = true;
		
		Period periodo = Period.between(datahoje, datasaida);
		int tamanho = periodo.getDays();
		
		for(int i=0;i<tamanho;i=i+1)
		{
			if(datahoje.isEqual(comparacao1) || datahoje.isEqual(comparacao2) || datasaida.isEqual(comparacao1) || datasaida.isEqual(comparacao2))
			{
				estado=false;
				break;
			}
		}
		return estado;
	}
}
