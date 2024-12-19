from odoo import fields, models


class Videojuego(models.Model):
   _name = "videojuegosreto2.videojuego"
   _description = 'tienda de videojuegos'


   #campos simples
   idVideojuego = fields.Integer(string = "ID del videojuego", required = True)
   titulo = fields.Char(string = "Titulo del videojuego")
   descripcion = fields.Text(string = "Descripción del videojuego")
   foto = fields.Char(string = "Foto del videojuego")
   genero = fields.Char(string = "Género del videojuego")
   precio = fields.Integer(string = "Precio del videojuego")
   pegi = fields.Integer(string = "PEGI del videojuego")
   fechaLanzamiento = fields.Date(string = "Fecha de lanzamiento del videojuego")

   # campos relacionales
   tienda = fields.Many2many("videojuegosreto2.tienda", string="tienda-videojuego", ondelete="cascade")
   plataforma = fields.Many2many("videojuegosreto2.plataforma", string="plataforma-videojuego", ondelete="cascade")
   desarrolladora = fields.Many2one("videojuegosreto2.desarrolladora", string="desarrolladora-videojuego", ondelete="cascade")
