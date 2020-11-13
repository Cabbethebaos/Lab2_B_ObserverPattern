public interface Movable {      // Ett interface som fungerar som en mall för de klasser som implementerar det
    void move();        // rörelse  metod som måste implementeras av "subklasser"

    void turnLeft();    // sväng vänster metod som måste implementeras av "subklasser"

    void turnRight();   // sväng höger metod som måste implementeras av "subklasser"
}