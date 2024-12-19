from odoo import fields, models

class Usuario(models.Model):
    _name = "videojuegosreto2.usuario"
    _description = 'Guarda los usuarios'

    # campos simples
    dni = fields.Char(string="DNI del usuario", required=True)
    nombreApellidos = fields.Char(string="Nombre y apellidos del usuario")
    email = fields.Char(string="Email del usuario")
    contraseña = fields.Char(string="Contraseña del usuario")
    telefono = fields.Integer(string="Telefono del usuario")
    ciudad = fields.Char(string="Ciudad del usuario")
    direccion = fields.Char(string="Direccion del usuario")
    zip = fields.Char(string="Zip del usuario")
    fechaNacimiento = fields.Date(string="Fecha de nacimiento del usuario")

    # campos relacionales
    compra = fields.One2many("videojuegosreto2.compra", inverse_name="usuario", string="usuario-compra", ondelete="cascade")