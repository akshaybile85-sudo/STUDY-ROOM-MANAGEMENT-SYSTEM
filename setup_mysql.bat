@echo off
echo === Step 1: Stopping MySQL service ===
net stop MySQL80
timeout /t 5 /nobreak

echo === Step 2: Creating init file ===
echo FLUSH PRIVILEGES; > C:\mysql_reset.sql
echo ALTER USER 'root'@'localhost' IDENTIFIED BY 'password'; >> C:\mysql_reset.sql

echo === Step 3: Starting MySQL with init-file ===
start "" "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqld.exe" --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini" --init-file=C:\mysql_reset.sql --console
timeout /t 10 /nobreak

echo === Step 4: Testing connection ===
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -ppassword -e "SELECT 'ROOT PASSWORD RESET SUCCESS!' AS status;"
if %errorlevel% neq 0 (
    echo PASSWORD RESET FAILED. Trying alternative method...
    timeout /t 5 /nobreak
    "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -ppassword -e "SELECT 1;"
)

echo === Step 5: Creating postgres user and database ===
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -ppassword -e "CREATE USER IF NOT EXISTS 'postgres'@'localhost' IDENTIFIED BY 'password'; GRANT ALL PRIVILEGES ON *.* TO 'postgres'@'localhost' WITH GRANT OPTION; FLUSH PRIVILEGES; CREATE DATABASE IF NOT EXISTS student; USE student; CREATE TABLE IF NOT EXISTS registeredstudent (id INT PRIMARY KEY, name VARCHAR(255), mobile_no VARCHAR(20), email VARCHAR(255), parentmob VARCHAR(20), college VARCHAR(255), edu VARCHAR(255), slot VARCHAR(50)); SHOW DATABASES; SHOW TABLES;"

echo === Step 6: Stopping mysqld and restarting service ===
taskkill /F /IM mysqld.exe
timeout /t 5 /nobreak
net start MySQL80
timeout /t 3 /nobreak

echo === Step 7: Final verification ===
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u postgres -ppassword -e "USE student; SHOW TABLES;"

echo.
echo === ALL DONE ===
pause
