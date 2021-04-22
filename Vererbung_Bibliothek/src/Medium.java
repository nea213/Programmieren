public class Medium {
    private int _medienNr;
    private String _title;
    private int _erscheinungsJahr;
    private String _rueckgabeDatum;
    private boolean _istAusgeliehen;
    private String _ausgeliehenDruch;

    public Medium(int _medienNr, String _title, int _erscheinungsJahr) {
        this._medienNr = _medienNr;
        this._title = _title;
        this._erscheinungsJahr = _erscheinungsJahr;
        this._istAusgeliehen = false;
    }

    public void ausleihenDurch(String name, String rueckgabeDatum) {
        this._ausgeliehenDruch = name;
        this._rueckgabeDatum = rueckgabeDatum;
        this._istAusgeliehen = true;
    }

    public void rueckgabe() {
        this._rueckgabeDatum = null;
        this._istAusgeliehen = false;
        this._ausgeliehenDruch = null;
    }

    public boolean istAusgeliehen() {
        return this._istAusgeliehen;
    }

    @Override
    public String toString() {
        return "Medium{" +
                "_medienNr=" + _medienNr +
                ", _title='" + _title + '\'' +
                ", _erscheinungsJahr=" + _erscheinungsJahr +
                ", _rueckgabeDatum='" + _rueckgabeDatum + '\'' +
                ", _istAusgeliehen=" + _istAusgeliehen +
                ", _ausgeliehenDruch='" + _ausgeliehenDruch + '\'' +
                '}';
    }


}
