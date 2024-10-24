DECLARE
    CURSOR DEPT_CURSOR IS
    SELECT
        DEPTNO,
        DNAME,
        LOC
    FROM
        DEPT;
    DEPT_RECORD DEPT_CURSOR%ROWTYPE;
BEGIN
    OPEN DEPT_CURSOR;
    LOOP
        FETCH DEPT_CURSOR INTO DEPT_RECORD;
        EXIT WHEN DEPT_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('DEPT NO: '
                             || DEPT_RECORD.DEPTNO
                             || ', DNAME: '
                             || DEPT_RECORD.DNAME
                             || ', Location: '
                             || DEPT_RECORD.LOC);
    END LOOP;

    CLOSE DEPT_CURSOR;
END;
/