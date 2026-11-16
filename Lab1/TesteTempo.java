public class TesteTempo {
    public static void main(String[] args) {
        System.out.println("--- a) Valores invalidos ---");
        Tempo tInvalido = new Tempo(24, 60, -10);
        System.out.println("Esperado 00:00:00 -> Obtido: " + tInvalido);

        System.out.println("\n--- b) Formato hhmmss ---");
        Tempo t1 = new Tempo(9, 30, 5);
        System.out.println("Esperado 093005 -> Obtido: " + t1.paraHhmmss());

        System.out.println("\n--- c) Formato AM/PM ---");
        System.out.println("09:30:05 -> " + t1.paraAmPm());
        System.out.println("00:15 -> " + new Tempo(0, 15, 0).paraAmPm());
        System.out.println("12:00 -> " + new Tempo(12, 0, 0).paraAmPm());
        System.out.println("13:05 -> " + new Tempo(13, 5, 0).paraAmPm());

        System.out.println("\n--- d) Acrescentar 1 segundo ---");
        Tempo tQuaseFim = new Tempo(10, 59, 59);
        System.out.println("Antes: " + tQuaseFim);
        tQuaseFim.acrescentarSegundo();
        System.out.println("Depois (+1s, esperado 11:00:00): " + tQuaseFim);

        System.out.println("\n--- e) Diferenca ---");
        Tempo tA = new Tempo(9, 30, 5);
        Tempo tB = new Tempo(7, 45, 50);
        Tempo diff = tA.diferenca(tB);
        System.out.println("Diferenca entre 09:30:05 e 07:45:50 (esperado 01:44:15) -> " + diff);
    }
}
