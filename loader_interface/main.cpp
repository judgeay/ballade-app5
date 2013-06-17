#include <iostream>
#include <fstream>
#include <string>
#include <stdexcept>
#include <cstdlib>

#include "loader_obj.h"
// (add new loaders here)

int main(int argc, char *argv[])
{
	if (argc < 2) {
		std::cerr << "Usage: " << argv[0] << " input_file" << '\n';
		return EXIT_FAILURE;
	}

	// Open the file
	const std::string fileName = argv[1];
	std::ifstream fileStream(fileName.c_str());
	if (!fileStream.is_open())
		throw std::runtime_error("Unable to open file: " + fileName);
	fileStream.exceptions(std::ifstream::failbit | std::ifstream::badbit);

	// Replace LoaderOBJ with your new loader
	LoaderPtr loader = createLoader<LoaderOBJ>();

	// Load the 3D model
	Mesh result = loader->load(fileName, fileStream);

	// Display some values
	std::cout << "File: " << fileName << '\n'
	          << "Points: " << result.vertices.size() << '\n'
	          << "Faces: "  << result.indices.size()/3 << '\n';
}
