@echo off
set PGPASSWORD=postgres
set BACKUP_DIR=C:\BackUp

REM Get the current date in YYYY-MM-DD format
for /f "tokens=1-3 delims=/ " %%a in ("%date%") do set DATE=%%c-%%a-%%b

REM Run pg_dump with the correct parameters and include the date in the filename
"C:\Program Files\PostgreSQL\16\bin\pg_dump.exe" -U postgres -h localhost -d "trabalhoFinal" -F c -b -v -f "%BACKUP_DIR%\backup_%DATE%.sql"

