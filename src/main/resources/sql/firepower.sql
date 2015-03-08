CREATE SEQUENCE seq_firepower START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS "public"."firepowers" (
  "id"         INT8 DEFAULT nextval('seq_firepower' :: REGCLASS) NOT NULL PRIMARY KEY,
  "number"       INT8,
  "type"       INT8,
  "statelongitude"       NUMERIC,
  "statelatitude"       NUMERIC,
  "stateheight"       NUMERIC,
  "rangemax"       NUMERIC,
  "rangemin"       NUMERIC,
  "azimutmax"       NUMERIC,
  "azimutmin"       NUMERIC,
  "placeanglemax"       NUMERIC,
  "placeanglemin"       NUMERIC,
  "operativnostmin"       NUMERIC,
  "operativnostmax"       NUMERIC,
  "chancesuccessmin"       NUMERIC,
  "chancesuccessmax"       NUMERIC,
  "chancesuccessratingresult"       NUMERIC,
  "chancefalsealarm"       NUMERIC,
  "countintime"       INT8);