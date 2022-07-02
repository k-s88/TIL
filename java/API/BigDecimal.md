10進数／2進数間で小数の値がずれることがある  
`System.out.println( 1.5 - 6 * 0.1 )`（double型）  
実行すると、『0.899999999999999999...』  
→BigDecimal型を使えばずれない  
`BigDecimal b1     = new BigDecimal( 1.5 ) ;`  
`BigDecimal b2     = new BigDecimal( -6 ) ;`  
`BigDecimal b3     = new BigDecimal( "0.1" ) ;`(「0.1」と表記すると10進数とずれる）  
`BigDecimal result = b1.add( b2.multiply( b3 ) ) ;`  
`System.out.println(result);`  
実行すると、『0.9』  
