interface Playable {

    void play();
}

class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Piano");
    }
}

public class Exercise19_InterfaceImplementation {

    public static void main(String[] args) {

        Guitar guitarInstrumentObject = new Guitar();
        Piano pianoInstrumentObject = new Piano();

        guitarInstrumentObject.play();
        pianoInstrumentObject.play();
    }
}