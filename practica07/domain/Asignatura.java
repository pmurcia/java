package practica07.domain;

public class Asignatura implements Comparable {
	private String name;
	private double credits;

	public Asignatura(String name, double credits)
	{
		this(name);
		this.setCredits(credits);
	}

	public Asignatura(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return name;
	}

	public double getCredits()
	{
		return credits;
	}

	private void setName(String name)
	{
		this.name = name;
	}

	private void setCredits(double credits)
	{
		this.credits = credits;
	}

	@Override
	public boolean equals(Object o)
	{
		return ((Asignatura) o).getName().equals(this.name);
	}

	public int compareTo(Object o)
	{
		return ((Asignatura) o).getName().compareTo(this.name);
	}

	@Override
	public String toString()
	{
		return this.name + " - " + this.credits;
	}
}