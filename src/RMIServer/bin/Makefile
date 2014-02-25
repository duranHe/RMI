JFLAGS =
JC = javac
.SUFFIXEs: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Message.java \
	RemoteObjectRef.java \
	RemoteStub.java \
	RMIExample.java \
	RMIPerson.java \
	RMIServer.java \
	RMIServerSkeleton.java \
	RMISubExample.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
