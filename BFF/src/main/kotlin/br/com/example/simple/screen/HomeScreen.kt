package br.com.example.simple.screen

import br.com.example.simple.compose.CategoryTemplate
import br.com.example.simple.compose.ProductCardTemplate
import br.com.example.simple.compose.ServicesBannerTemplate
import br.com.example.simple.constants.*
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

object HomeScreen : ScreenBuilder {

    val margin = EdgeValue(top = 10.unitReal(), left = 15.unitReal(), bottom = 10.unitReal())

    override fun build(): Screen {
        return Screen(
                safeArea = SafeArea(top = false),
                style = Style(backgroundColor = LIGHT_BACKGROUND),
                child = ScrollView(
                        children = listOf(
                                Text(text = "Categorias", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                                        margin = margin
                                )
                                ),
                                categoriesList.applyStyle(Style(margin = EdgeValue(left = 15.unitReal(), bottom = 10.unitReal(), right = 15.unitReal()))),
                                Text(text = "Oportunidades", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                                        margin = EdgeValue(left = 15.unitReal(), bottom = 10.unitReal())
                                )
                                ),
                                opportunitiesList,
                                Text(text = "Serviços", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                                        margin = margin
                                )
                                ),
                                serviceList,
                                Text(text = "Produtos perto de você", styleId = STYLE_TEXT_H1, textColor = DARK_BLUE).applyStyle(style = Style(
                                        margin = margin
                                )
                                ),
                                products
                        )
                )
        )
    }

    private val banner = Touchable(
            onPress = listOf(
                    Navigate.PushView(route = Route.Remote(url = "/store"))
            ),
            child = Image(path = ImagePath.Local.justMobile("banner")).applyStyle(
                    style = Style(
                            size = Size(width = 300.unitReal(), height = 200.unitReal()),
                            margin = EdgeValue(right = 20.unitReal())
                    )
            )
    )

    private val serviceList = ScrollView(
            scrollBarEnabled = false,
            scrollDirection = ScrollAxis.HORIZONTAL,
            children = listOf(
                    ServicesBannerTemplate(image = "blackBanner", description = "\nPrecisa de alguma ajuda para reformar móveis de madeira?\nPor favor, entre em contato!", textColor = WHITE),
                    ServicesBannerTemplate(image = "orangeBanner", description = "\nSeu celular ou computador está com defeito?\nConte comigo!\n", textColor = BLACK),
                    ServicesBannerTemplate(image = "yellowBanner", description = "\nOfereço meus serviços como entregador no período da tarde e noite.\nPara mais informações entre em contato.", textColor = BLACK),
                    ServicesBannerTemplate(image = "blueBanner", description = "\nPrecisa de um motorista e gostaria de um preço mais barato que aplicativos de transporte?\nEntre em contato.", textColor = BLACK)
            )
    )

    private val opportunitiesList = ScrollView(
            scrollBarEnabled = false,
            scrollDirection = ScrollAxis.HORIZONTAL,
            children = listOf(
                    ServicesBannerTemplate(image = "blueBanner", description = "\nOportunidade para pedreiros: Trabalho na período da manhã!\nEntre em contato.", textColor = BLACK),
                    ServicesBannerTemplate(image = "yellowBanner", description = "\nPrecisamos de cabeleireiros com disponibilidade na parte da tarde.\nPara mais informações entre em contato.", textColor = BLACK),
                    ServicesBannerTemplate(image = "orangeBanner", description = "\nOportunidade para mecânico! Horário integral, \npara mais informações entre em contato.", textColor = BLACK),
                    ServicesBannerTemplate(image = "orangeBanner2", description = "\nOportunidade para entregador para os bairros: Santa Mônica e Centro.\nEntre em contato.", textColor = BLACK)
            )
    )

    private val categoriesList = Container(
            children = listOf(
                    CategoryTemplate(text = "Produtos", image = "productsicon", url = "/product"),
                    CategoryTemplate(text = "Lojas", image = "shop", url = "/store"),
                    CategoryTemplate(text = "Serviços", image = "services", url = "/service"),
                    CategoryTemplate(text = "Oportunidade", image = "opportunity1", url = "/opportunity")
            )
    ).applyStyle(style = Style(
            flex = Flex(flexDirection = FlexDirection.ROW, alignItems = AlignItems.FLEX_START),
            margin = EdgeValue(top = 5.unitReal())
    )
    )

    private val products = ScrollView(
            scrollBarEnabled = false,
            children = listOf(
                    ProductCardTemplate(image = "product4", priceText = "R$ 7.80", productName = "Batom Basic 01 VulT", description = "Super confortável nos lábios, o Batom Basic da Vult proporciona uma boa cobertura e um acabamento cremoso. Fácil de espalhar e em textura leve, o batom garante lábios com cores sensacionais."),
                    ProductCardTemplate(image = "product1", priceText = "R$ 10.00", productName = "Camisa Feminina Baby Look Billie Eilish", description = "\n" +
                            "Tecido: 100%algodão fio 30.1\n" + "\n" + "ESTAMPA: SUBLIMAÇÃO E VINIL EMBORRACHADO\n" + "\n" +
                            "Qualidade do Tecido, Estampa e Costura.\n" + "\n" + "Excelente custo benefício, preço baixo e qualidade!\n" + "\n" +
                            "baby look super confortável, tecido leve ideal para treinos e Lazer aos finais de semana.\n"),
                    ProductCardTemplate(image = "product2", priceText = "R$ 20.00", productName = "Camisa Adidas Feminina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tBABY LOOK\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" +
                            "Gênero: Feminino\n" + "Material principal: 100% ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductCardTemplate(image = "product3", priceText = "R$ 7.00", productName = "Camisa Adidas Masculina", description = "Marca\tIBI MODAS\n" +
                            "Modelo\tCamiseta\n" + "Desenho do tecido\tGeométrico\n" + "Outras características\n" + "Gênero: Masculino\n" +
                            "Material principal: 100% ALGODÃO\n" + "Tipo de manga: Curta\n" + "Tipo de gola: REDONDA"),
                    ProductCardTemplate(image = "product5", priceText = "R$ 76.00", productName = "Colônia Moto Soul 100ml", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tUomini Desodorante Colônia Moto Soul 100ml\n" +
                            "Versão\tMoto Soul\n" + "Gênero\tMasculino\n" + "Tipo\tDes. Colônia\n" + "Volume da unidade\t100 mL"),
                    ProductCardTemplate(image = "product6", priceText = "R$ 90.00", productName = "Kit Flower De Floratta\n", description = "Marca\tO Boticário\n" +
                            "Nome do perfume\tFloratta\n" + "Gênero\tFeminino\n" + "Tipo\tColônia\n" + "Volume da unidade\t90 mL")
            )
    )
}