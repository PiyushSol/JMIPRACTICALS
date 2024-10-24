SET SERVEROUTPUT ON;

DECLARE
    X    NUMBER;
    FACT NUMBER;
    J NUMBER;
    RES NUMBER;
    FUNCTION FACTORIAL(
        X IN NUMBER
    ) RETURN NUMBER IS
    BEGIN
        J :=1;
        RES:=1;
        IF (X=0) THEN
            RES:=1;
        END IF;

        FOR J IN 1..X LOOP
            RES:= RES * J;
        END LOOP;

        RETURN RES;
    END;
BEGIN
    X:= &X;
    FACT := FACTORIAL(X);
    DBMS_OUTPUT.PUT_LINE('THE FACTORIAL OF : '
                         ||X
                         ||' IS '
                         ||FACT);
END;
/