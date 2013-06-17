#ifndef MESH_H
#define MESH_H

#include <vector>

#include "linear_math.h"

struct Mesh
{
	std::vector<Vector3> vertices;
	std::vector<Vector2> texCoords;
	std::vector<Vector3> normals;
	std::vector<Vector3> colors;

	// Indices for vertex/texcoord/normal values in the
	// vertices/texCoords/normals arrays
	struct Index { unsigned int v, t, n, c; };
	std::vector<Index> indices;
};

#endif /* MESH_H */
