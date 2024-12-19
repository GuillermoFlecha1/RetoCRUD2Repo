from odoo import fields,models

class Plataforma(models.Model):
    _name = "videojuegosreto2.plataforma"
    _description = 'guarda las plataformas'


    #campos simples
    idPlataforma=fields.Integer(string="El id unico del videojuego", required=True)
    nomPlataforma=fields.Char(string="Nombre de la Plataforma")
    lectorDisco = fields.Boolean(string="Tiene lector de disco o no")
    ram = fields.Char(string="La capacidad de ram que tiene la consola")
    almacenamiento = fields.Char(string="El almacenamiento total que tiene la consola")
    logo = fields.Char(string="La ruta de la imagen del logo")
    anioLanzamiento = fields.Date(string="la fecha de lanzamiento")
    nomEmpresa = fields.Char(string="El nombre de la empresa")

    #campos relacionales
    videojuego = fields.Many2many("videojuegosreto2.videojuego", string="plataforma-videojuego", ondelete="cascade")