package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




val LaranjaFoodLog = Color(0xFFF4511E)
val FundoFoodLog = Color(0xFFF7F7F7)




class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {


                //TelaHome()
                TelaBusca()
                // TelaNovoLog()
            }
        }
    }
}



@Composable
fun TelaHome() {

    val context = LocalContext.current


    Scaffold(


        bottomBar = {
            BarraVisual()
        }

    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FundoFoodLog)

                // ✅ REQUISITO: padding
                .padding(paddingValues)
                .padding(20.dp)
        ) {




            Row(
                modifier = Modifier.fillMaxWidth(),


                horizontalArrangement = Arrangement.SpaceBetween,


                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "FoodLog",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = LaranjaFoodLog
                )

                Text(
                    text = "⌕",
                    fontSize = 26.sp
                )
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )




            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FiltroHome(
                    texto = "Tudo",
                    ativo = true
                )

                FiltroHome(
                    texto = "Hambúrguer",
                    ativo = false
                )

                FiltroHome(
                    texto = "Japonês",
                    ativo = false
                )
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )




            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )


                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )


                        Column {

                            Text(
                                text = "@murilo.dev",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )

                            Text(
                                text = "São Paulo, SP",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )



                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFFFE0D6)),

                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "🍝\nFoto do prato",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    }


                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )


                    Text(
                        text = "Carbonara Tradicional",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "Cantina da Nonna",
                        fontSize = 14.sp,
                        color = LaranjaFoodLog
                    )


                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "★ 4.8",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "R$ 42,00",
                            fontWeight = FontWeight.Bold
                        )
                    }


                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )


                    Text(
                        text = "Muito saboroso e otimo preçc. Voltarei novamente!"
                    )


                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(25.dp)
                    ) {

                        Text("♡ 128")

                        Text("💬 23")
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(16.dp)
            )




            Button(


                onClick = {


                    Toast.makeText(
                        context,
                        "Criar novo Log",
                        Toast.LENGTH_SHORT
                    ).show()
                },

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    containerColor = LaranjaFoodLog
                )
            ) {

                Text(
                    text = "Novo Log",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}




@Composable
fun FiltroHome(
    texto: String,
    ativo: Boolean
) {


    Surface(
        shape = RoundedCornerShape(10.dp),

        color = if (ativo) {
            LaranjaFoodLog
        } else {
            Color(0xFFEAEAEA)
        }
    ) {

        Text(
            text = texto,

            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),

            color = if (ativo) {
                Color.White
            } else {
                Color.DarkGray
            },

            fontSize = 12.sp
        )
    }
}




@Composable
fun TelaBusca() {

    val context = LocalContext.current




    var pesquisa by remember {
        mutableStateOf("")
    }



    Scaffold(

        bottomBar = {
            BarraVisual()
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FundoFoodLog)
                .padding(paddingValues)
                .padding(20.dp)
        ) {


            Text(
                text = "Buscar",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )



            OutlinedTextField(


                value = pesquisa,


                onValueChange = {

                    pesquisa = it
                },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Buscar prato ou restaurante...")
                },

                singleLine = true,

                shape = RoundedCornerShape(12.dp)
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )



            Button(


                onClick = {

                    Toast.makeText(
                        context,
                        "Buscando: $pesquisa",
                        Toast.LENGTH_SHORT
                    ).show()
                },

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    containerColor = LaranjaFoodLog
                )
            ) {

                Text(
                    text = "Buscar",
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            Text(
                text = "Filtros",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FiltroSimples(
                    texto = "Tudo",
                    ativo = true
                )

                FiltroSimples(
                    texto = "$",
                    ativo = false
                )

                FiltroSimples(
                    texto = "$$",
                    ativo = false
                )

                FiltroSimples(
                    texto = "★ 4.0+",
                    ativo = false
                )
            }


            Spacer(
                modifier = Modifier.height(25.dp)
            )


            Text(
                text = "Pratos em alta",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            ResultadoBusca(
                nome = "Burger House",
                descricao = "Hambúrguer • 1,2 km",
                nota = "★ 4.8"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            ResultadoBusca(
                nome = "Sushi Garden",
                descricao = "Japonês • 2,1 km",
                nota = "★ 4.7"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            ResultadoBusca(
                nome = "Cantina da Nonna",
                descricao = "Italiana • 3,0 km",
                nota = "★ 4.9"
            )
        }
    }
}



@Composable
fun FiltroSimples(
    texto: String,
    ativo: Boolean
) {

    Surface(
        shape = RoundedCornerShape(20.dp),

        color = if (ativo) {
            LaranjaFoodLog
        } else {
            Color(0xFFEAEAEA)
        }
    ) {

        Text(
            text = texto,

            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 8.dp
            ),

            color = if (ativo) {
                Color.White
            } else {
                Color.DarkGray
            }
        )
    }
}




@Composable
fun ResultadoBusca(
    nome: String,
    descricao: String,
    nota: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        shape = RoundedCornerShape(14.dp)
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFFE0D6)),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "🍽️",
                    fontSize = 27.sp
                )
            }


            Spacer(
                modifier = Modifier.width(14.dp)
            )


            Column {

                Text(
                    text = nome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = descricao,
                    color = Color.Gray,
                    fontSize = 13.sp
                )


                Spacer(
                    modifier = Modifier.height(5.dp)
                )


                Text(
                    text = nota,
                    color = LaranjaFoodLog,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}




@Composable
fun TelaNovoLog() {

    val context = LocalContext.current




    // ✅ remember + mutableStateOf

    var nomePrato by remember {
        mutableStateOf("")
    }

    var restaurante by remember {
        mutableStateOf("")
    }

    var preco by remember {
        mutableStateOf("")
    }

    var comentario by remember {
        mutableStateOf("")
    }

    var nota by remember {
        mutableStateOf(0)
    }


    Scaffold(

        bottomBar = {
            BarraVisual()
        }

    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FundoFoodLog)

                // Permite rolar a tela
                .verticalScroll(
                    rememberScrollState()
                )

                .padding(paddingValues)
                .padding(20.dp)
        ) {


            Text(
                text = "Novo Log",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )


            Text(
                text = "Registre uma nova experiência gastronômica",
                fontSize = 13.sp,
                color = Color.Gray
            )


            Spacer(
                modifier = Modifier.height(20.dp)
            )




            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFFFE0D6)),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "+\nAdicionar foto",
                    textAlign = TextAlign.Center,
                    color = LaranjaFoodLog,
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(
                modifier = Modifier.height(15.dp)
            )




            OutlinedTextField(

                value = nomePrato,

                // ✅ Lambda
                onValueChange = {
                    nomePrato = it
                },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Nome do prato")
                },

                singleLine = true
            )


            Spacer(
                modifier = Modifier.height(10.dp)
            )




            OutlinedTextField(

                value = restaurante,

                onValueChange = {
                    restaurante = it
                },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Onde você comeu?")
                },

                singleLine = true
            )


            Spacer(
                modifier = Modifier.height(18.dp)
            )




            Text(
                text = "Sua nota",
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(5.dp)
            )



            AvaliacaoEstrelas(

                nota = nota,

                // ✅ Lambda criada por nós
                onNotaChange = {

                    nota = it
                }
            )


            Spacer(
                modifier = Modifier.height(10.dp)
            )




            OutlinedTextField(

                value = preco,

                onValueChange = {
                    preco = it
                },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Preço pago")
                },

                prefix = {
                    Text("R$ ")
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),

                singleLine = true
            )


            Spacer(
                modifier = Modifier.height(10.dp)
            )




            OutlinedTextField(

                value = comentario,

                onValueChange = {
                    comentario = it
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),

                label = {
                    Text("Comentário")
                }
            )


            Spacer(
                modifier = Modifier.height(20.dp)
            )





            Button(


                onClick = {


                    Toast.makeText(
                        context,
                        "Review publicada!",
                        Toast.LENGTH_SHORT
                    ).show()
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = LaranjaFoodLog
                ),

                shape = RoundedCornerShape(12.dp)
            ) {

                Text(
                    text = "Publicar Review",
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}




@Composable
fun AvaliacaoEstrelas(

    nota: Int,


    onNotaChange: (Int) -> Unit
) {

    Row {

        for (i in 1..5) {

            Text(

                text = if (i <= nota) {
                    "★"
                } else {
                    "☆"
                },

                color = LaranjaFoodLog,

                fontSize = 34.sp,


                modifier = Modifier.clickable {

                    onNotaChange(i)
                }
            )
        }
    }
}




@Composable
fun BarraVisual() {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp
                ),

            horizontalArrangement = Arrangement.SpaceAround,

            verticalAlignment = Alignment.CenterVertically
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("⌂")

                Text(
                    text = "Home",
                    fontSize = 11.sp
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("⌕")

                Text(
                    text = "Busca",
                    fontSize = 11.sp
                )
            }


            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(LaranjaFoodLog),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("○")

                Text(
                    text = "Perfil",
                    fontSize = 11.sp
                )
            }
        }
    }
}