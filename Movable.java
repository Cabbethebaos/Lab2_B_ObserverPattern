/** Interface är en helt abstrakt klass som har i syfte att skapa metoder som inte skapar objekt.
 * Metoderna som finns i Interface kan fås genom att implementera och objekten/body skapas i klassen som implementerar
 * Interfaces kan man implementera flera av till skillnad från extends.
 * Vi gör en interface Movable som innehåller metoderna move, turnDir. Dessa metoder är statiska
 * */
public interface Movable {
    /**
     * rörelse  metod som måste implementeras av "subklasser"
     */
    void move();

    /**
     * sväng vänster metod som måste implementeras av "subklasser"
     */
    void turnLeft();

    /**
     * sväng höger metod som måste implementeras av "subklasser"
     */
    void turnRight();
}
