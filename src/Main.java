/*
 * Gerardo Hernandez
 * HW2-1
 * Due Date 02/16/2017
 */

import java.util.Scanner ;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int cases = 0 ;
		String dna, marker ;
		int[] output ;
		int N ;

		System.out.println("Input: ");
		cases = input.nextInt() ;
		output = new int[cases] ;
		
		for(int i = 0 ; i < cases ; i++)
		{
		
			input.nextInt();
			input.nextInt();
			dna = input.next();
			marker = input.next();
	
			if(!inSequence(marker,dna))
			{
				output[i] = 0 ;
			}
			else
			{
				N = markerDuplicates(marker);
				output[i] = markerCount(N) ;
				continue;
				
			}

		}
		
		for(int j = 0 ; j < cases ; j++)
		{
			System.out.println(output[j]);
		}
			
		


		
		
		input.close();
	}
	
	
	
	public static int markerDuplicates(String marker)
	{
		char[] m = marker.toCharArray() ;
		int in = m.length ;
		
		for(int i = 0 ; i < m.length; i++)
		{
			for(int j = i +1 ; j < m.length; j++)
			{
				
				if(m[i] == m[j])
				{
					in -= 1 ;
				}
				
			}
			
			
		}
		
		
		return in ;
	}
	
	
	public static boolean inSequence(String marker, String dna)
	{
		char[] m = marker.toCharArray(); 
		char[] d = dna.toCharArray() ;
		
		for(int i = 0 ; i < m.length; i++)
		{
			for(int j = 0 ; j < d.length; j++)
			{
				if(m[i] == d[j])
				{
					break ;
				}
				else if(m[i] != d[j] && (j+1) == d.length)
				{
					return false ;
				}
			}
			
		}
		
		return true ;
	}
	
	public static int markerCount(int N)
	{
		int totalMarker = 0 ;
		if(N > 3)
		{
			for(int p = 1 ; p < N ; p++)
			{
				
				totalMarker += (p - N);
				
			}
			
			totalMarker = totalMarker * (-1) + 1 ;
			
			return totalMarker ;
		}
		
		return N ;

		
	}

}
