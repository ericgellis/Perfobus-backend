-- Create sequences --
CREATE SEQUENCE public.mobithink_uid
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- drop tables of link --
DROP TABLE IF EXISTS public."line_station_link";

-- drop entities tables --
DROP TABLE IF EXISTS public."bus_line";
DROP TABLE IF EXISTS public."city";
DROP TABLE IF EXISTS public."event";
DROP TABLE IF EXISTS public."picture";
DROP TABLE IF EXISTS public."voice_memo";
DROP TABLE IF EXISTS public."rolling_point";
DROP TABLE IF EXISTS public."station";
DROP TABLE IF EXISTS public."station_data";
DROP TABLE IF EXISTS public."trip";

-- create tables of link --

CREATE TABLE public.bus_line
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    creation_date bigint NOT NULL,
    city_id bigint NOT NULL,
    CONSTRAINT bus_line_pkey PRIMARY KEY (id)
);

CREATE TABLE public.city
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id)
);

CREATE TABLE public.event
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint,
    station_data_id bigint,
    trip_id bigint NOT NULL,
    gps_lat DOUBLE PRECISION,
    gps_long DOUBLE PRECISION,
    gps_endlat DOUBLE PRECISION,
    gps_endlong DOUBLE PRECISION,
    time_saving DOUBLE PRECISION,
    CONSTRAINT event_pkey PRIMARY KEY (id)
);

CREATE TABLE public.line_station_link
(
    id bigint NOT NULL,
    bus_line_id bigint NOT NULL,
    station_id bigint NOT NULL,
    step integer NOT NULL,
    CONSTRAINT line_sation_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.picture
(
    id bigint NOT NULL,
    station_data_id bigint,
    event_id bigint,
    picture_name TEXT,
    CONSTRAINT picture_pkey PRIMARY KEY (id)
);

CREATE TABLE public.voice_memo
(
    id bigint NOT NULL,
    voice_memo_name TEXT,
    event_id bigint,
    CONSTRAINT voice_memo_pkey PRIMARY KEY (id)
);

CREATE TABLE public.rolling_point
(
    id bigint NOT NULL,
    point_time bigint,
    traffic integer,
    trip_id bigint NOT NULL,
    gps_lat DOUBLE PRECISION,
    gps_long DOUBLE PRECISION,
    speed DOUBLE PRECISION,
    CONSTRAINT rolling_point_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT station_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station_data
(
    id bigint NOT NULL,
    come_in integer NOT NULL,
    go_out integer NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint NOT NULL,
    step integer,
    station_name text COLLATE pg_catalog."default",
    trip_id bigint NOT NULL,
    gps_lat DOUBLE PRECISION,
    gps_long DOUBLE PRECISION,
    CONSTRAINT station_data_pkey PRIMARY KEY (id)
);

CREATE TABLE public.trip
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint NOT NULL,
    atmo integer,
    temperature text,
    weather text COLLATE pg_catalog."default",
    vehicle_capacity integer,
    start_gps_lat DOUBLE PRECISION,
    start_gps_long DOUBLE PRECISION,
    end_gps_lat DOUBLE PRECISION,
    end_gps_long DOUBLE PRECISION,
    bus_line_id bigint,
    CONSTRAINT trip_pkey PRIMARY KEY (id)
);