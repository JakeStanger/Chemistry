	private void generateTexturesForElements()
	{
		for(Element element : this.elements)
		{
			if(element != null && !new File("generatedtextures" + element.getName() + "png").isFile()) 
			{
				String text = element.getSymbol();
				Group group = element.getGroup();
			
		        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = img.createGraphics();
		        
		        Font font;
		        if(text.length() <= 2) font = new Font("Helvetica", Font.PLAIN, 45);
		        else font = new Font("Helvetica", Font.PLAIN, 32);
		        
		        Color colour;
		        switch(group)
		        {
		        	case ALKALI_METALS:
		        		colour = Color.WHITE;
		        		break;
		        	case ALKALINE_EARTH_METALS:
		        		colour = Color.PINK;
		        		break;
		        	case TRANSITION_METALS:
		        		colour = Color.CYAN.darker();
		        		break;
		        	case OTHER_METALS:
		        		colour = Color.ORANGE;
		        		break;
		        	case NON_METALS:
		        		colour = Color.GREEN;
		        		break;
		        	case NOBLE_GASES:
		        		colour = Color.YELLOW;
		        		break;
		        	default:
		        		colour = Color.WHITE;
		        }
		        
		        g2d.setFont(font);
		        FontMetrics fm = g2d.getFontMetrics();
		        g2d.dispose();
		
		        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		        g2d = img.createGraphics();
		        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		        g2d.setColor(colour);
		        g2d.draw3DRect(0, 0, img.getWidth(), img.getHeight(), false);
		        g2d.fill3DRect(0, 0, 64, 64, false);
		        
		        g2d.setFont(font);
		        fm = g2d.getFontMetrics();
		        g2d.setColor(colour.brighter().darker().brighter()); //This gives a colour slightly different to a single brighter
		        
		        g2d.drawString(text, 32- fm.stringWidth(text)/2, 32+ fm.getDescent() + 5);
		        g2d.dispose();
		        try 
		        {
		            ImageIO.write(img, "png", new File("generatedtextures/" + element.getName() + ".png"));
		        } 
		        catch (IOException ex) 
		        {
		            ex.printStackTrace();
		        }
			}
		}
	}