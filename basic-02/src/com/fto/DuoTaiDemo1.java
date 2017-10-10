package com.fto;

public class DuoTaiDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MainBoard mb = new MainBoard();
        mb.run();
        mb.useCard(new SoundCard());
        mb.useCard(new NestCard());
    }

}

class MainBoard {
    public void run() {
        System.out.println("mainboard run");
    }

    public void useCard(PCI p) {
        p.open();
        p.close();
    }
}

interface PCI {
    void open();

    void close();
}

class NestCard implements PCI {
    public void open() {
        System.out.println("nestcard open");
    }

    public void close() {
        System.out.println("nestcard close");
    }
}

class SoundCard implements PCI {
    public void open() {
        System.out.println("SoundCard open");
    }

    public void close() {
        System.out.println("SoundCard close");
    }
}


