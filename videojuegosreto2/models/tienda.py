# -*- coding:utf-8 -*-
from odoo import fields, models


class Tienda(models.Model):
   _name = "videojuegosreto2.tienda"
   _description = 'Guarda las tiendas'


   #campos simples
   cif = fields.Char(string="cif de la tienda", required=True)
   nomTienda = fields.Char(string="nombre de la tienda")
   web = fields.Char(string="web de la tienda")
   direccion = fields.Char(string="direccion de la tienda")
   telefonoTienda = fields.Integer(string="telefono de la tienda")
   fechaCreacion = fields.Date(string="fecha de creacion de la tienda")
   logo = fields.Char(string="logo de la tienda")

   # campos relacionales
   videojuegos = fields.Many2many("videojuegosreto2.videojuego", string="tienda-videojuego", ondelete="cascade")
   compra = fields.One2many("videojuegosreto2.compra", inverse_name="tienda", string="tienda-compra", ondelete="cascade")