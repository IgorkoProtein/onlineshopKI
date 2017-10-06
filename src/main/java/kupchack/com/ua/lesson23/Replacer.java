package kupchack.com.ua.lesson23;

public class Replacer {

    private IRead reader;
    private IShow shower;

    public Replacer(IRead reader, IShow shower) {
        this.reader = reader;
        this.shower = shower;
    }

    public void replace(){
        String readLine = reader.readInformatoin();
        String replaceLine = readLine.replace("0", "9");
        shower.showInformation(replaceLine);
    }
}
