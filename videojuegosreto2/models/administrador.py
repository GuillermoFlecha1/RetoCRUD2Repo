from odoo import fields, models

class Administrador(models.Model):
    _name = "videojuegosreto2.administador"
    _inherit = "videojuegosreto2.usuario"

    # campos simples
    fechaCreacion = fields.Date(string="fecha creacion del usuario", required=True)