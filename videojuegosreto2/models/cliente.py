from odoo import fields, models

class Cliente(models.Model):
    _name = "videojuegosreto2.cliente"
    _inherit = "videojuegosreto2.usuario"

    # campos simples
    iban = fields.Char(string="iban del usuario", required=True)