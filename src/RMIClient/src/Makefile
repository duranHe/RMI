JFLAGS =
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Message.java \
	Proxy.java \
	RemoteObjectRef.java \
	RemoteStub.java \
	RMIClient.java \
	RMIExample_stub.java \
	RMIPerson.java \
	RMISubExample_stub.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
