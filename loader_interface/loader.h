#ifndef LOADER_H
#define LOADER_H

#include <istream>
#include <memory>

#include "mesh.h"

struct Loader
{
	// "fileName" is only used for error reporting.
	// "stream" is the input stream from which the file data will be read.
	virtual Mesh load(const std::string& fileName,
	                  std::istream& stream) = 0;

	virtual ~Loader() {}
};

// If std::unique_ptr<> is not recognized, enable C++0x/C++11
// support in your compiler options!
typedef std::unique_ptr<Loader> LoaderPtr;

// Factory method
template <typename T>
LoaderPtr createLoader() { return LoaderPtr(new T); }

#endif /* LOADER_H */
