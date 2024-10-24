DECLARE
    N1      NUMBER;
    N2      NUMBER;
    N3      NUMBER;
    MAXIMUM NUMBER;
BEGIN
    N1:=&N1;
    N2:=&N2;
    N3:=&N3;
    IF(N1>=N2) AND (N1>=N3) THEN
        MAXIMUM := N1;
    ELSIF (N2>=N3) THEN
        MAXIMUM :=N2;
    ELSE
        MAXIMUM :=N3;
    END IF;

    DBMS_OUTPUT.PUT_LINE('The Maximum among the numbers is : '
                         || MAXIMUM);
END;
/