package practica07.ui;

import practica07.domain.Asignatura;

import practica07.util.Leer;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class App {

	private static Collection collection;

	public static void main(String[] args)
	{
		int opcion = App.setPriority();
		switch(opcion)
		{
			case 1:
				collection = new ArrayList();
				break;
			case 2:
				collection = new LinkedList();
				break;
			case 3:
				collection = new TreeSet();
				break;
			case 4:
				collection = new HashSet();
				break;
			default:
				System.out.println("Error");
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		App.chooseOption();
	}

	private static int setPriority()
	{
		int i = 0;

		System.out.println("Seleccione la prioridad que desea.");
		System.out.println("1. Utilizar una coleccion que de prioridad al acceso directo.");
		System.out.println("2. Utilizar una coleccion que de prioridad a las inserciones y eliminaciones.");
		System.out.println("3. Utilizar una coleccion que no admita duplicados.");
		System.out.println("4. Utilizar una coleccion que ordene las ocurrencias que almacena.");
		System.out.print("\n\tOpcion => ");

		String opcion = Leer.porTeclado();

		try
		{
			i = Integer.parseInt(opcion);
		} catch(Exception e)
		{
			e.printStackTrace();
		}

		return i;
	}

	private static void chooseOption()
	{
		int opcion = 0;

		do
		{
			System.out.println("1. Agregar una asignatura.");
			System.out.println("2. Eliminar una asignatura.");
			System.out.println("3. Mostrar toda la informacion.");
			System.out.println("4. Insertar en una posicion concreta.");
			System.out.println("5. Mostrar la asignatura de una posicion dada.");
			System.out.print("\n\tOpcion => ");

			String input = Leer.porTeclado();

			try
			{
				opcion = Integer.parseInt(input);
			} catch(Exception e)
			{
				e.printStackTrace();
			}

			switch(opcion)
			{
				case 1:
					collection.add(createAsignatura());
					break;
				case 2:
					collection.remove(new Asignatura(Leer.porTeclado()));
					break;
				case 3:
					collection
						.stream()
						.forEach(System.out::println);
					break;
				case 4:
					if(collection instanceof List){
						System.out.println("Introduzca el indice:");
						try
						{
							int index = Integer.parseInt(Leer.porTeclado());
							List col = (List) collection;
							col.add(index,createAsignatura());
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					} else {
						System.out.println("No se puede introducir en un lugar determinado.");
					}
					break;
				case 5:
					if(collection instanceof List){
						List col = (List) collection;
						try
						{
							int indexInput = Integer.parseInt(Leer.porTeclado());
							System.out.println(col.get(indexInput));
						} catch (Exception e)
						{
							e.printStackTrace();
						}
					} else {
						Iterator it = collection.iterator();
						int indexA = 0;
						try
						{
							indexA = Integer.parseInt(Leer.porTeclado());
						}catch(Exception e)
						{
							e.printStackTrace();
						}

						for(int i = 0; i < indexA; i++) it.next();

						System.out.println(it.next());
					}
					break;
				case 6:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("ERROR.");
			}

		} while(opcion != 6);
	}

	private static Asignatura createAsignatura()
	{
		Asignatura a = null;

		System.out.print("\n\nIntroduzca el nombre de la asignatura: ");
		String name = Leer.porTeclado();
		System.out.print("\nIntroduzca el numero de creditos: ");
		try
		{
			double credits = Double.parseDouble(Leer.porTeclado());
			a = new Asignatura(name,credits);
		} catch(Exception e){
			System.out.println("Error");
		}
		return a;
	}
}