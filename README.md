# SE320 Class Examples

This repository has a range of examples used for demonstrating different testing concepts in lecture.

The main things here are:

- ```docker.sh``` is a script which will download a Docker image with OpenJDK13 and give you a shell from which you can run the gradle-related commands in a Linux environment. This might be useful if you're on Windows, or have a different JDK version installed (having multiple installed is often easy to break).  It mounts the current directory under ```/class``` in the container.
  + We would welcome someone porting this to a Windows .cmd form
- ```gradlew``` and ```gradlew.bat``` are scripts which will download and run gradle from this directory, for building the code or running ```gradlew test```
- ```Testing.ipynb``` is a Jupyter notebook that lets us play with some tests in a different live format in lecture.  To load it, you'll need the [IJava](https://github.com/SpencerPark/IJava) Jupyter kernel, which adds Java support to Jupyter.

For further instructions, come to class!
