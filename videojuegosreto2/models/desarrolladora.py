from odoo import fields,models


class Desarrolladora(models.Model):
   _name = "videojuegosreto2.desarrolladora"
   _description = 'Empresas desarrolladoras'


   #campos simples
   cif = fields.Char(string="Cif de la empresa", required=True)
   nomEmpresa = fields.Char(string="Nombre de la empresa")
   telefonoDesarrolladora = fields.Integer(string="Telefono de la desarrolladora")
   fechaCreacion = fields.Date(string="Fecha de creación de la empresa")
   numEmpleados = fields.Integer(string="Numero de empleados de la empresa")
   siglas = fields.Char(string="Siglas de la empresa")
   logo = fields.Char(string="Ruta del logo de la empresa")

   # campos relacionales
   videojuego = fields.One2many("videojuegosreto2.videojuego", inverse_name="desarrolladora", string="desarrolladora-videojuego", ondelete="cascade")