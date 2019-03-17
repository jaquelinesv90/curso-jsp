CREATE TABLE public.chamado
(
  id numeric NOT NULL DEFAULT nextval('seq_chamado'::regclass),
  titulo character varying,
  descricao character varying,
  status character varying,
  id_usuario numeric NOT NULL,
  numchamado numeric,
  diasaberto numeric,
  dataabertura date,
  CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
      REFERENCES public.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE public.usuario
(
  id numeric NOT NULL,
  email character varying,
  senha character varying,
  CONSTRAINT id PRIMARY KEY (id)
);

-- sequence
CREATE SEQUENCE public.seq_chamado
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5
  CACHE 1;
ALTER TABLE public.seq_chamado
  OWNER TO postgres;
  
 -- sequence
CREATE SEQUENCE public.seq_usuario
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5
  CACHE 1;
ALTER TABLE public.seq_usuario
  OWNER TO postgres;
  
  
ALTER TABLE usuario ALTER COLUMN id SET DEFAULT nextval('seq_usuario');
