package org.polytech.project.balladeapp5;

public class Vector2
{
	public Vector2()
	{
        xy[0] = 0;
        xy[1] = 0;
	}

	public Vector2(double x, double y)
	{
        xy[0] = x;
        xy[1] = y;
	}

	public Vector2(double[] array)
	{
		if(array.length != 2)
			throw new RuntimeException("Must create vector with 3 element array");

        xy[0] = array[0];
        xy[1] = array[1];
	}
	
	public double[] array()
	{
		return (double[])xy.clone();
	}

	public Vector2 add(Vector2 rhs)
	{
		return new Vector2(
                xy[0] + rhs.xy[0],
                xy[1] + rhs.xy[1]);
	}

	public Vector2 sub(Vector2 rhs)
	{
		return new Vector2(
                xy[0] - rhs.xy[0],
                xy[1] - rhs.xy[1]);
	}
	
	public Vector2 neg()
	{
		return new Vector2(-xy[0], -xy[1]);
	}

	public Vector2 mul(double c)
	{
		return new Vector2(c*xy[0], c*xy[1]);
	}

	public Vector2 div(double c)
	{
		return new Vector2(xy[0]/c, xy[1]/c);
	}

	public double dot(Vector2 rhs)
	{
		return xy[0]*rhs.xy[0] +
                xy[1]*rhs.xy[1];
	}

	public boolean equals(Object obj)
	{
		if( obj instanceof Vector2 )
		{
			Vector2 rhs = (Vector2)obj;

			return xy[0]==rhs.xy[0] &&
                    xy[1]==rhs.xy[1];
		}
		else
		{
			return false;
		}
		
	}

	public double norm()
	{
		return Math.sqrt(this.dot(this));	
	}

	public Vector2 normalize()
	{
		return this.div(norm());
	}

	public double x()
	{
		return xy[0];
	}
	
	public double y()
	{
		return xy[1];
	}

	public String toString()
	{
		return "( " + xy[0] + " " + xy[1] + " )";
	}
	
	/*package*/ double xy[] = new double[2];
}
