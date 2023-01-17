JFLAGS = -g
JC = javac

DIR= simulator/

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC_NAME = \
	Aircraft \
  AircraftFactory \
	Baloon \
	Flyable \
	Coordinates \
	Helicopter \
	JetPlane \
	Main \
	Simulator \
	Tower \
	WeatherProvider \
	WeatherTower 

SRCS = $(addprefix $(DIR), $(SRC_NAME))

JAVA = .java
CLASS = .class

CLASSES = $(addsuffix $(JAVA), $(SRCS))

CLASS_FILE = $(addsuffix $(CLASS), $(SRCS))

default: classes

classes: $(CLASSES:.java=.class)

run :
	java $(addprefix $(DIR), Main)

clean:
	$(RM) $(CLASS_FILE)
