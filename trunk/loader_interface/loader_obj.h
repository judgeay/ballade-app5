#ifndef LOADER_OBJ_H
#define LOADER_OBJ_H

#include "loader.h"

struct LoaderOBJ : public Loader
{
	// NOTE: this loader only supports "v", "vn" and "vt" in OBJ
	// files, and requires all three of them (along with "f")
	Mesh load(const std::string& fileName,
	          std::istream& stream);
};

#endif /* LOADER_OBJ_H */
