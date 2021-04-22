import java.util.ArrayList;

public class Buch extends Medium{
    private String _isbn;
    private ArrayList<String> _autoren;

    @Override
    public String toString() {
        return "Buch{" +
                "_isbn='" + _isbn + '\'' +
                ", _autoren=" + _autoren +
                '}' + " -> " +
                super.toString();
    }

    public Buch(int _medienNr,
                String _title,
                int _erscheinungsJahr,
                String _isbn,
                ArrayList<String> _autoren
    ) {
        super(_medienNr, _title, _erscheinungsJahr);
        this._isbn = _isbn;
        this._autoren = _autoren;
    }
}
