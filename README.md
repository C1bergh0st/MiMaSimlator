#UPDATE:
You can find a complete Overhaul [here](https://github.com/C1bergh0st/MiMaSim)

# MiMaSimlator 
This is a [MiMa Simulator](http://ti.ira.uka.de/Visualisierungen/Mima/mima-aufgaben.pdf). 
MiMa stands for MinimalMaschine, a theoretical microprocessor used to teach Theoretical Computer Science at the KIT in Germany.
This Version uses a Modified Commandset:

## Commandset:
<table style="\width:" 417px\="">
<tbody>
<tr>
<td style="\width:" 51px\=""> Binary</td>
<td style="\width:" 55px\="">"Code" </td>
<td style="\width:" 309px\="">Meaning </td>
</tr>
<tr>
<td style="\width:" 51px\="">0000</td>
<td style="\width:" 55px\="">LDC c</td>
<td style="\width:" 309px\=""> c → Akku</td>
</tr>
<tr>
<td style="\width:" 51px\="">0001 </td>
<td style="\width:" 55px\="">LDV a </td>
<td style="\width:" 309px\=""> &lt a &gt → Akku</td>
</tr>
<tr>
<td style="\width:" 51px\="">0010 </td>
<td style="\width:" 55px\="">STV a </td>
<td style="\width:" 309px\="">Akku →&lt a &gt</td>
</tr>
<tr>
<td style="\width:" 51px\="">0011 </td>
<td style="\width:" 55px\="">ADD a </td>
<td style="\width:" 309px\="">Akku &lt a &gt  → Akku </td>
</tr>
<tr>
<td style="\width:" 51px\="">0100 </td>
<td style="\width:" 55px\="">AND a</td>
<td style="\width:" 309px\="">Akku AND &lt a &gt  → Akku </td>
</tr>
<tr>
<td style="\width:" 51px\="">0101 </td>
<td style="\width:" 55px\="">OR a </td>
<td style="\width:" 309px\="">Akku OR &lt a &gt→ Akku</td>
</tr>
<tr>
<td style="\width:" 51px\="">0110 </td>
<td style="\width:" 55px\="">XOR a </td>
<td style="\width:" 309px\="">Akku XOR &lt a &gt→ Akku </td>
</tr>
<tr>
<td style="\width:" 51px\="">0111</td>
<td style="\width:" 55px\="">EQL a</td>
<td style="\width:" 309px\="">if(Akku == &lt a &gt) { -1  → Akku} else { 0 → Akku}</td>
</tr>
<tr>
<td style="\width:" 51px\="">1000</td>
<td style="\width:" 55px\="">JMP a</td>
<td style="\width:" 309px\="">Sprung zu Adresse a</td>
</tr>
<tr>
<td style="\width:" 51px\="">1001</td>
<td style="\width:" 55px\="">JMN a</td>
<td style="\width:" 309px\="">Wenn Akku < 0 dann Sprung zu Adresse a</td>
</tr>
<tr>
<td style="\width:" 51px\="">1010</td>
<td style="\width:" 55px\="">LDIV a</td>
<td style="\width:" 309px\=""><&lt a &gt> → Akku</td>
</tr>
<tr>
<td style="\width:" 51px\="">1011</td>
<td style="\width:" 55px\="">STIV a</td>
<td style="\width:" 309px\="">Akku → <&lt a &gt></td>
</tr>
<tr>
<td style="\width:" 51px\="">1100</td>
<td style="\width:" 55px\="">RAR</td>
<td style="\width:" 309px\="">Rotiert den Akku eins nach rechts (und das rechteste Bit an die linkeste Stelle)</td>
</tr>
<tr>
<td style="\width:" 51px\="">1101</td>
<td style="\width:" 55px\="">NOT</td>
<td style="\width:" 309px\="">Invertiert jedes Bit des Akku</td>
</tr>
<tr>
<td style="\width:" 51px\="">1110</td>
<td style="\width:" 55px\="">EMPTY</td>
<td style="\width:" 309px\="">Unbenutzt, eventuell später JIND a</td>
</tr>
<tr>
<td style="\width:" 51px\="">1111</td>
<td style="\width:" 55px\="">HALT</td>
<td style="\width:" 309px\="">Stoppt die Mima</td>
</tr>
</tbody>
</table>

## Download
Latest Version: [Download](https://github.com/C1bergh0st/MiMaSimlator/raw/master/MiMa.jar)

