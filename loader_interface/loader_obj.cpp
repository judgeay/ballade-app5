#include "loader_obj.h"
#include "utility.h"

#include <stdexcept>
#include <climits>

namespace
{
	void parseV(Mesh& mesh, const std::string& /*fileName*/, std::istream& stream)
	{
		std::string str;
		stream >> str;

		if (str == "v") {
			float x, y, z;
			stream >> x >> y >> z;
			mesh.vertices.push_back(Vector3(x, y, z));
		} else if (str == "vt") {
			float u, v;
			stream >> u >> v;
			mesh.texCoords.push_back(Vector2(u, v));
		} else if (str == "vn") {
			float x, y, z;
			stream >> x >> y >> z;
			mesh.normals.push_back(Vector3(x, y, z));
		}
	}

	void parseF(Mesh& mesh, const std::string& fileName, std::istream& stream)
	{
		stream.ignore(1, '\n'); // skip 'f'

		for (int i = 0; i < 3; ++i) {
			std::string str;
			stream >> str;

			const std::vector<std::string> indices = Utility::split(str, '/');

			if (indices.empty())
				throw std::runtime_error("Invalid face: \"" + str + "\"");

			if (indices.size() < 2 || indices[1].empty())
				throw std::runtime_error("Missing texture coordinate index (" + fileName + ")");
			if (indices.size() < 3 || indices[2].empty())
				throw std::runtime_error("Missing vertex normal index (" + fileName + ")");

			Mesh::Index index;
			index.v = Utility::fromStringExcept<unsigned int>(indices[0]);
			index.t = Utility::fromStringExcept<unsigned int>(indices[1]);
			index.n = Utility::fromStringExcept<unsigned int>(indices[2]);
			index.c = 0; // no vertex colors in OBJ files

			if (index.v == 0 || index.t == 0 || index.n == 0)
				throw std::runtime_error("Invalid index: 0 (" + fileName + ")");

			// OBJ indices are 1-indexed
			--index.v;
			--index.t;
			--index.n;

			mesh.indices.push_back(index);
		}
	}

	Mesh parse(const std::string& fileName, std::istream& stream)
	{
		Mesh result;

		while (!stream.eof()) {
			switch (stream.peek()) {
				case 'v':
					parseV(result, fileName, stream);
					break;

				case 'f':
					parseF(result, fileName, stream);
					break;

				case '#': // comments
				default:
					break;
			}

			if (!stream.eof()) {
				// Skip until the next line
				stream.ignore(INT_MAX, '\n');
			}
		}

		if (result.indices.size() % 3)
			throw std::runtime_error("Invalid number of faces (" + fileName + ")");

		return result;
	}

} // namespace

Mesh LoaderOBJ::load(const std::string& fileName,
                     std::istream& stream)
{
	return parse(fileName, stream);
}
