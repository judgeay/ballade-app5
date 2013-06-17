#ifndef LINEAR_MATH_H
#define LINEAR_MATH_H

#include <ostream>

struct Vector2
{
	Vector2()
	{ /* uninitialized */ }

	Vector2(float x_, float y_)
	 : x(x_), y(y_)
	{}

	explicit Vector2(float scalar)
	 : x(scalar), y(scalar)
	{}

	explicit Vector2(float const (&array)[2])
	 : x(array[0]), y(array[1])
	{}

	Vector2& operator=(const Vector2& other)
	{
		x = other.x;
		y = other.y;
		return *this;
	}

	friend std::ostream& operator<<(std::ostream& os, const Vector2& v)
	{
		os << "Vector2(" << v.x << ", " << v.y << ")";
		return os;
	}

	float x, y;
};

struct Vector3
{
	Vector3()
	{ /* uninitialized */ }

	Vector3(float x_, float y_, float z_)
	 : x(x_), y(y_), z(z_)
	{}

	explicit Vector3(float scalar)
	 : x(scalar), y(scalar), z(scalar)
	{}

	explicit Vector3(float const (&array)[3])
	 : x(array[0]), y(array[1]), z(array[2])
	{}

	Vector3& operator=(const Vector3& other)
	{
		x = other.x;
		y = other.y;
		z = other.z;
		return *this;
	}

	friend std::ostream& operator<<(std::ostream& os, const Vector3& v)
	{
		os << "Vector3(" << v.x << ", " << v.y << ", " << v.z << ")";
		return os;
	}

	float x, y, z;
};

#endif /* LINEAR_MATH_H */
