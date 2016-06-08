package comercioeletronico

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CarrinhoCompras)
@Mock([ListaProduto, CarrinhoCompras])
class CarrinhoComprasSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Obter número de produtos no carrinho de compras"() {
        given: "Um carrinho de compras"
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

        and: "Três produtos adicionados no carrinho"
        carrinhoCompras.addToItens(new ListaProduto())
        carrinhoCompras.addToItens(new ListaProduto())
        carrinhoCompras.addToItens(new ListaProduto())

        expect: "Que o número de itens no carrinho seja igual a 3"
        carrinhoCompras.numeroItens == 3

    }

    void "Calcular preco total do carrinho"() {
        given: "Um carrinho de compras"
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

        and: "Três produtos adicionados no carrinho"
        Produto produto1 = new Produto(preco: 10)
        carrinhoCompras.addToItens(new ListaProduto(produto: produto1, quantidade: 10))
        Produto produto2 = new Produto(preco: 5)
        carrinhoCompras.addToItens(new ListaProduto(produto: produto2, quantidade: 1))
        Produto produto3 = new Produto(preco: 7)
        carrinhoCompras.addToItens(new ListaProduto(produto: produto3, quantidade: 7))

        expect: "Que o preço total do carrinho seja igual a 154"
        carrinhoCompras.precoTotal == 154

    }
}
