package com.r_ware.r_openlib.oversampledoscillatorexample;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.r_ware.r_openlib.r_oversampling.*;
//[/user-imports]


public class OversampledOscillatorExample extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

    public OversampledOscillatorExample( long moduleID, VoltageObjects voltageObjects )
    {
        super( moduleID, voltageObjects, "Oversampled Oscillator Example", ModuleType.ModuleType_Oscillators, 1.2 );

        InitializeControls();


        canBeBypassed = false;
        SetSkin( "de53e8a919b5483282c7cb5595e576af" );
    }

void InitializeControls()
{

        textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "OVERSAMPLED OSCILLATOR EXAMPLE" );
        AddComponent( textLabel1 );
        textLabel1.SetWantsMouseNotifications( false );
        textLabel1.SetPosition( 2, 0 );
        textLabel1.SetSize( 82, 61 );
        textLabel1.SetEditable( false, false );
        textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel1.SetBorderSize( 1 );
        textLabel1.SetMultiLineEdit( false );
        textLabel1.SetIsNumberEditor( false );
        textLabel1.SetNumberEditorRange( 0, 100 );
        textLabel1.SetNumberEditorInterval( 1 );
        textLabel1.SetNumberEditorUsesMouseWheel( false );
        textLabel1.SetHasCustomTextHoverColor( false );
        textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel1.SetFont( "Arial", 14, true, false );

        freqKnob = new VoltageKnob( "freqKnob", "Frequency", this, 20, 2000, 100 );
        AddComponent( freqKnob );
        freqKnob.SetWantsMouseNotifications( false );
        freqKnob.SetPosition( 21, 171 );
        freqKnob.SetSize( 44, 44 );
        freqKnob.SetSkin( "Plastic White" );
        freqKnob.SetRange( 20, 2000, 100, false, 0 );
        freqKnob.SetKnobParams( 215, 145 );
        freqKnob.DisplayValueInPercent( false );
        freqKnob.SetKnobAdjustsRing( true );
        freqKnob.SetMidpointValue( 400 );

        textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "FREQUENCY" );
        AddComponent( textLabel2 );
        textLabel2.SetWantsMouseNotifications( false );
        textLabel2.SetPosition( 2, 152 );
        textLabel2.SetSize( 82, 18 );
        textLabel2.SetEditable( false, false );
        textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel2.SetBorderSize( 1 );
        textLabel2.SetMultiLineEdit( false );
        textLabel2.SetIsNumberEditor( false );
        textLabel2.SetNumberEditorRange( 0, 100 );
        textLabel2.SetNumberEditorInterval( 1 );
        textLabel2.SetNumberEditorUsesMouseWheel( false );
        textLabel2.SetHasCustomTextHoverColor( false );
        textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel2.SetFont( "Arial", 12, true, false );

        osFactorSwitch = new VoltageSwitch( "osFactorSwitch", "Oversampling Factor", this, 0 );
        AddComponent( osFactorSwitch );
        osFactorSwitch.SetWantsMouseNotifications( false );
        osFactorSwitch.SetPosition( 12, 102 );
        osFactorSwitch.SetSize( 63, 15 );
        osFactorSwitch.SetSkin( "5-State Slide Horizontal" );

        textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "OVERSAMPLING FACTOR" );
        AddComponent( textLabel3 );
        textLabel3.SetWantsMouseNotifications( false );
        textLabel3.SetPosition( 2, 73 );
        textLabel3.SetSize( 82, 29 );
        textLabel3.SetEditable( false, false );
        textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel3.SetBorderSize( 1 );
        textLabel3.SetMultiLineEdit( false );
        textLabel3.SetIsNumberEditor( false );
        textLabel3.SetNumberEditorRange( 0, 100 );
        textLabel3.SetNumberEditorInterval( 1 );
        textLabel3.SetNumberEditorUsesMouseWheel( false );
        textLabel3.SetHasCustomTextHoverColor( false );
        textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel3.SetFont( "Arial", 12, true, false );

        waveformSelectionSwitch = new VoltageSwitch( "waveformSelectionSwitch", "Waveform Selection", this, 0 );
        AddComponent( waveformSelectionSwitch );
        waveformSelectionSwitch.SetWantsMouseNotifications( false );
        waveformSelectionSwitch.SetPosition( 29, 259 );
        waveformSelectionSwitch.SetSize( 27, 15 );
        waveformSelectionSwitch.SetSkin( "2-State Slide Bright Horizontal" );

        textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "WAVEFORM" );
        AddComponent( textLabel4 );
        textLabel4.SetWantsMouseNotifications( false );
        textLabel4.SetPosition( 2, 236 );
        textLabel4.SetSize( 82, 18 );
        textLabel4.SetEditable( false, false );
        textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel4.SetBorderSize( 1 );
        textLabel4.SetMultiLineEdit( false );
        textLabel4.SetIsNumberEditor( false );
        textLabel4.SetNumberEditorRange( 0, 100 );
        textLabel4.SetNumberEditorInterval( 1 );
        textLabel4.SetNumberEditorUsesMouseWheel( false );
        textLabel4.SetHasCustomTextHoverColor( false );
        textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel4.SetFont( "Arial", 12, true, false );

        textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "OUT" );
        AddComponent( textLabel5 );
        textLabel5.SetWantsMouseNotifications( false );
        textLabel5.SetPosition( 2, 300 );
        textLabel5.SetSize( 82, 18 );
        textLabel5.SetEditable( false, false );
        textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel5.SetBorderSize( 1 );
        textLabel5.SetMultiLineEdit( false );
        textLabel5.SetIsNumberEditor( false );
        textLabel5.SetNumberEditorRange( 0, 100 );
        textLabel5.SetNumberEditorInterval( 1 );
        textLabel5.SetNumberEditorUsesMouseWheel( false );
        textLabel5.SetHasCustomTextHoverColor( false );
        textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel5.SetFont( "Arial", 12, true, false );

        out = new VoltageAudioJack( "out", "OUT", this, JackType.JackType_AudioOutput );
        AddComponent( out );
        out.SetWantsMouseNotifications( false );
        out.SetPosition( 22, 317 );
        out.SetSize( 37, 37 );
        out.SetSkin( "Jack Straight" );
}



    //-------------------------------------------------------------------------------
    //  public void Initialize()

        //  Initialize will get called shortly after your module's constructor runs. You can use it to
        //  do any initialization that the auto-generated code doesn't handle.
    //-------------------------------------------------------------------------------
    @Override
    public void Initialize()
    {
        //[user-Initialize]   Add your own initialization code here

        m_frequency     = new SmoothValue();
        m_oscillator    = new BadOscillator( Values.SampleRate );
        m_downsampler   = new R_NO_Downsampler();


        //[/user-Initialize]
    }


    //-------------------------------------------------------------------------------
    //  public void Destroy()

        //  Destroy will get called just before your module gets deleted. You can use it to perform any
        //  cleanup that's not handled automatically by Java.
    //-------------------------------------------------------------------------------
    @Override
    public void Destroy()
    {
        super.Destroy();
        //[user-Destroy]   Add your own module-getting-deleted code here



        //[/user-Destroy]
    }


    //-------------------------------------------------------------------------------
    //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

        //  Notify will get called when various events occur - control values changing, timers firing, etc.
    //-------------------------------------------------------------------------------
    @Override
    public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
    {
        //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
        switch( notification )
        {
            case Knob_Changed:   // doubleValue is the new VoltageKnob value
            {
                if( component == freqKnob )
                {
                    m_frequency.SetValue( doubleValue );
                    return true;
                }
            }
            break;
        
            case Slider_Changed:   // doubleValue is the new slider value
            {
            }
            break;
        
            case Button_Changed:   // doubleValue is the new button/toggle button value
            {
            }
            break;
        
            case Switch_Changed:   // doubleValue is the new switch value
            {
                if( component == osFactorSwitch )
                {
                    switch( (int)doubleValue )
                    {
                        case 0:
                            m_osFactor = 1;
                            break;
                        case 1:
                            m_osFactor = 2;
                            break;
                        case 2:
                            m_osFactor = 4;
                            break;
                        case 3:
                            m_osFactor = 8;
                            break;
                        case 4:
                            m_osFactor = 16;
                            break;
                    }

                    m_oscillator.setSampleRate( m_osFactor * Values.SampleRate );

                    if( m_osFactor == 1 )
                    {
                        m_downsampler   = new R_NO_Downsampler();
                    }
                    else
                    {
                        m_downsampler   = new R_IIR_Downsampler(
                                Values.SampleRate,
                                m_osFactor,
                                20e3
                                );
                    }
                    return true;
                }

                if( component == waveformSelectionSwitch )
                {
                    m_isSaw = doubleValue > 0.5;
                    m_oscillator.setToSaw( m_isSaw );
                    return true;
                }
            }
            break;
        
            case Jack_Connected:   // longValue is the new cable ID
            {
            }
            break;
        
            case Jack_Disconnected:   // All cables have been disconnected from this jack
            {
            }
            break;
        
            case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
            {
            }
            break;
        
            case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
            {
            }
            break;
        
            case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
            {
            }
            break;
        
            case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
            {
            }
            break;
        
            case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
            {
            }
            break;
        
            case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
            {
            }
            break;
        
            case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
            {
            }
            break;
        
            case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
            {
            }
            break;
        
            // Less common notifications:
        
            case Named_Timer:   // object contains a String with the name of the timer that has fired
            {
            }
            break;
        
            case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
            {
            }
            break;
        
            case Canvas_Painted:   // Canvas painting is complete
            {
            }
            break;
        
            case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
            {
            }
            break;
        
            case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
            {
            }
            break;
        
            case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
            {
            }
            break;
        
            case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
            {
            }
            break;
        
            case Label_Changed:        // The text of an editable text control has changed
            {
            }
            break;
        
            case SoundPlayback_Start:   // A sound has begun playback
            {
            }
            break;
        
            case SoundPlayback_End:     // A sound has ended playback
            {
            }
            break;
        
            case Scrollbar_Position:    // longValue is the new scrollbar position
            {
            }
            break;
        
            case PolyVoices_Changed:    // longValue is the new number of poly voices
            {
            }
            break;
        
            case File_Dropped:     // 'object' is a String containing the file path
            {
            }
            break;
        
            case Preset_Loading_Start:   // called when preset loading begins
            {
            }
            break;
        
            case Preset_Loading_Finish:  // called when preset loading finishes
            {
            }
            break;
        
            case Variation_Loading_Start:    // sent when a variation is about to load
            {
            }
            break;
        
            case Variation_Loading_Finish:   // sent when a variation has just finished loading
            {
            }
            break;
        
            case Tempo_Changed:     // doubleValue is the new tempo
            {
            }
            break;
        
            case Randomized:     // called when the module's controls get randomized
            {
            }
            break;
        
            case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
            {
            }
            break;
        
            case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
            {
            }
            break;
        
            case Reset:    // sent when the module has been reset to default settings
            {
            }
            break;
        
            case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
            {
            }
            break;
        
            case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
            {
            }
            break;
        
            case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
            {
            }
            break;
        }



        return false;
        //[/user-Notify]
    }


    //-------------------------------------------------------------------------------
    //  public void ProcessSample()

        //  ProcessSample is called once per sample. Usually it's where you read
        //  from input jacks, process audio, and write it to your output jacks.
        //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
        //  to other threads when possible and avoid calling native functions.
    //-------------------------------------------------------------------------------
    @Override
    public void ProcessSample()
    {
        //[user-ProcessSample]   Add your own process-sampling code here
        double[] values = new double[ m_osFactor ];
        double outputValue = 0.0;

        m_oscillator.setFrequency( m_frequency.GetSmoothValue() );
        outputValue = m_downsampler.process( m_oscillator );

        /* ALTERNATIVE
        if( m_isSaw )
        {
            for( int i = 0; i < m_osFactor; ++i )
            {
                m_oscillator.advance();
                values[i] = m_oscillator.getSawValue();
            }
        }
        else
        {
            for( int i = 0; i < m_osFactor; ++i )
            {
                m_oscillator.advance();
                values[i] = m_oscillator.getSquareValue();
            }
        }

        outputValue = m_downsampler.process( values );
        ALTERNATIVE */

        out.SetValue( 5.0 * outputValue );

        //[/user-ProcessSample]
    }


    //-------------------------------------------------------------------------------
    //  public String GetTooltipText( VoltageComponent component )

        //  Gets called when a tooltip is about to display for a control. Override it if
        //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
        //  for instance, you can translate the knob's current value to a log-based string and display it here.
    //-------------------------------------------------------------------------------
    @Override
    public String GetTooltipText( VoltageComponent component )
    {
        //[user-GetTooltipText]   Add your own code here



        return super.GetTooltipText( component );
        //[/user-GetTooltipText]
    }


    //-------------------------------------------------------------------------------
    //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

        //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
        //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
        //  in GetTooltipText().
    //-------------------------------------------------------------------------------
    @Override
    public void EditComponentValue( VoltageComponent component, double newValue, String newText )
    {
        //[user-EditComponentValue]   Add your own code here



        //[/user-EditComponentValue]
        super.EditComponentValue( component, newValue, newText );
    }


    //-------------------------------------------------------------------------------
    //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

        //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
        //  process them in this function when they get triggered by undo/redo actions.
    //-------------------------------------------------------------------------------
    @Override
    public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
    {
        //[user-OnUndoRedo]   Add your own code here



        //[/user-OnUndoRedo]
    }


    //-------------------------------------------------------------------------------
    //  public byte[] GetStateInformation()

        //  Gets called when the module's state gets saved, typically when the user saves a preset with
        //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
        //  but if you have any custom state information you need to save, return it from this function.
    //-------------------------------------------------------------------------------
    @Override
    public byte[] GetStateInformation()
    {
        //[user-GetStateInformation]   Add your own code here



        return null;
        //[/user-GetStateInformation]
    }


    //-------------------------------------------------------------------------------
    //  public void SetStateInformation(byte[] stateInfo)

        //  Gets called when this module's state is getting restored, typically when a user opens a preset with
        //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
    //-------------------------------------------------------------------------------
    @Override
    public void SetStateInformation(byte[] stateInfo)
    {
        //[user-SetStateInformation]   Add your own code here



        //[/user-SetStateInformation]
    }


    //-------------------------------------------------------------------------------
    //  public byte[] GetStateInformationForVariations()

        //  Gets called when a user saves a variation with this module in it.
        //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
        //  but if you have any custom state information you need to save, return it from this function.
    //-------------------------------------------------------------------------------
    @Override
    public byte[] GetStateInformationForVariations()
    {
        //[user-GetStateInformationForVariations]   Add your own code here



        return GetStateInformation();
        //[/user-GetStateInformationForVariations]
    }


    //-------------------------------------------------------------------------------
    //  public void SetStateInformationForVariations(byte[] stateInfo)

        //  Gets called when a user loads a variation with this module in it.
        //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
    //-------------------------------------------------------------------------------
    @Override
    public void SetStateInformationForVariations(byte[] stateInfo)
    {
        //[user-SetStateInformationForVariations]   Add your own code here
        SetStateInformation(stateInfo);



        //[/user-SetStateInformationForVariations]
    }


    // Auto-generated variables
    private VoltageAudioJack out;
    private VoltageLabel textLabel5;
    private VoltageLabel textLabel4;
    private VoltageSwitch waveformSelectionSwitch;
    private VoltageLabel textLabel3;
    private VoltageSwitch osFactorSwitch;
    private VoltageLabel textLabel2;
    private VoltageKnob freqKnob;
    private VoltageLabel textLabel1;


    //[user-code-and-variables]    Add your own variables and functions here
    private class BadOscillator implements R_IValueGenerator
    {
        //THIS IS A BAD OSCILLATOR IMPLEMENTATION INTENTIONALLY USED TO SHOWCASE
        //OVERSAMPLED OSCILLATOR!
        //DO NOT USE IN ACTUAL MODULES!
        public BadOscillator( double sampleRate )
        {
            m_sampleRate        = sampleRate;
            m_sampleRateRecip   = 1.0 / m_sampleRate;
            m_phase             = 0.0;
        }

        public void setSampleRate( double sampleRate )
        {
            m_phi               *= m_sampleRate; // convert back to frequency
            m_sampleRate        = sampleRate;
            m_sampleRateRecip   = 1.0 / m_sampleRate;
            m_phi               *= m_sampleRateRecip; //new phase accumulator increment
        }

        public void setFrequency( double frequency )
        {
            //only positive frequencies supported
            m_phi   = frequency * m_sampleRateRecip;
        }

        public void setToSaw( boolean isSaw )
        {
            m_isSaw = isSaw;
        }

        public void advance()
        {
            // these naive implementations will alias badly
            m_sawValue = 2.0 * m_phase - 1.0;
            m_squareValue = Math.signum( m_sawValue );

            //accumulate phase
            m_phase += m_phi;
            //wrap phase in range 0..1
            m_phase -= (int)m_phase;
        }

        public double getSawValue()
        {
            return m_sawValue;
        }

        public double getSquareValue()
        {
            return m_squareValue;
        }

        public double getValue()
        {
            advance();
            return m_isSaw ? getSawValue() : getSquareValue();
        }

        private double  m_sampleRate;
        private double  m_sampleRateRecip;
        private double  m_phase;
        private double  m_phi;
        private double  m_sawValue;
        private double  m_squareValue;
        private boolean m_isSaw;
    }

    private int                 m_osFactor;
    private boolean             m_isSaw;
    private SmoothValue         m_frequency;
    private BadOscillator       m_oscillator;
    private R_IDownsampler      m_downsampler;
    //[/user-code-and-variables]
}

 