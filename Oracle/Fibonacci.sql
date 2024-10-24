SET SERVEROUTPUT on;

DECLARE
    F0  INTEGER :=0;
    F1  INTEGER :=1;
    J   INTEGER;
    F2  INTEGER;
    NUM INTEGER;
BEGIN
    NUM := &NUM;
    DBMS_OUTPUT.PUT_LINE('The series is : ');
    DBMS_OUTPUT.PUT_LINE(F0);
    DBMS_OUTPUT.PUT_LINE(F1);
    FOR J IN 1..NUM LOOP
        F2 := F0+F1;
        F0 :=F1;
        F1 :=F2;
        DBMS_OUTPUT.PUT_LINE(F2
        );
    END LOOP;
END;
/