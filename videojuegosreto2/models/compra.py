from odoo import fields, models

class Compra(models.Model):
    _name = "videojuegosreto2.compra"
    _description = 'Guarda las compras'

    # campos simples
    fechaCompra = fields.Date(string="fecha de compra", required=True)

    # campos relacionales
    usuario = fields.Many2one("videojuegosreto2.usuario", string="usuario-compra", ondelete="cascade")
    tienda = fields.Many2one("videojuegosreto2.tienda", string="tienda-compra", ondelete="cascade")