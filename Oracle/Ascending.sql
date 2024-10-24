SET SERVEROUTPUT ON;

DECLARE
    NUM1     NUMBER := &NUM1; -- First number
    NUM2     NUMBER := &NUM2; -- Second number
    NUM3     NUMBER := &NUM3; -- Third number
    SMALLEST NUMBER;
    MIDDLE   NUMBER;
    LARGEST  NUMBER;
BEGIN
 
    -- Determine the smallest, middle, and largest numbers
    IF (NUM1 <= NUM2) AND (NUM1 <= NUM3) THEN
        SMALLEST := NUM1;
        IF (NUM2 <= NUM3) THEN
            MIDDLE := NUM2;
            LARGEST := NUM3;
        ELSE
            MIDDLE := NUM3;
            LARGEST := NUM2;
        END IF;
    ELSIF (NUM2 <= NUM1) AND (NUM2 <= NUM3) THEN
        SMALLEST := NUM2;
        IF (NUM1 <= NUM3) THEN
            MIDDLE := NUM1;
            LARGEST := NUM3;
        ELSE
            MIDDLE := NUM3;
            LARGEST := NUM1;
        END IF;
    ELSE
        SMALLEST := NUM3;
        IF (NUM1 <= NUM2) THEN
            MIDDLE := NUM1;
            LARGEST := NUM2;
        ELSE
            MIDDLE := NUM2;
            LARGEST := NUM1;
        END IF;
    END IF;
 

    -- Display the numbers in ascending order
    DBMS_OUTPUT.PUT_LINE('Numbers in ascending order: '
                         || SMALLEST
                         || ', '
                         || MIDDLE
                         || ', '
                         || LARGEST);
END;
/