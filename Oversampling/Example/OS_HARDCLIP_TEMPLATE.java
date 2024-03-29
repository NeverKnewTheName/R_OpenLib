package com.r_ware.r_openlib.oshardcliptemplate;


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


public class OSHardclipTemplate extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

    public OSHardclipTemplate( long moduleID, VoltageObjects voltageObjects )
    {
        super( moduleID, voltageObjects, "OS HARDCLIP TEMPLATE", ModuleType.ModuleType_Utility, 1.2 );

        InitializeControls();


        canBeBypassed = false;
        SetSkin( "f23cd814cda0419fb0346dc24d224ebc" );
    }

void InitializeControls()
{

        in = new VoltageAudioJack( "in", "IN", this, JackType.JackType_AudioInput );
        AddComponent( in );
        in.SetWantsMouseNotifications( false );
        in.SetPosition( 22, 252 );
        in.SetSize( 37, 37 );
        in.SetSkin( "Jack Straight" );

        out = new VoltageAudioJack( "out", "OUT", this, JackType.JackType_AudioOutput );
        AddComponent( out );
        out.SetWantsMouseNotifications( false );
        out.SetPosition( 25, 316 );
        out.SetSize( 37, 37 );
        out.SetSkin( "Jack Straight" );

        osFactorSwitch = new VoltageSwitch( "osFactorSwitch", "Oversampling Factor", this, 0 );
        AddComponent( osFactorSwitch );
        osFactorSwitch.SetWantsMouseNotifications( false );
        osFactorSwitch.SetPosition( 15, 102 );
        osFactorSwitch.SetSize( 63, 15 );
        osFactorSwitch.SetSkin( "5-State Slide Horizontal" );

        osTypeSwitch = new VoltageSwitch( "osTypeSwitch", "Oversampling Type", this, 0 );
        AddComponent( osTypeSwitch );
        osTypeSwitch.SetWantsMouseNotifications( false );
        osTypeSwitch.SetPosition( 30, 143 );
        osTypeSwitch.SetSize( 27, 15 );
        osTypeSwitch.SetSkin( "2-State Slide Horizontal" );

        textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "OS FACTOR" );
        AddComponent( textLabel1 );
        textLabel1.SetWantsMouseNotifications( false );
        textLabel1.SetPosition( 2, 72 );
        textLabel1.SetSize( 80, 30 );
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
        textLabel1.SetFont( "<Sans-Serif>", 14, true, false );

        textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "TYPE" );
        AddComponent( textLabel6 );
        textLabel6.SetWantsMouseNotifications( false );
        textLabel6.SetPosition( 4, 117 );
        textLabel6.SetSize( 80, 30 );
        textLabel6.SetEditable( false, false );
        textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel6.SetBorderSize( 1 );
        textLabel6.SetMultiLineEdit( false );
        textLabel6.SetIsNumberEditor( false );
        textLabel6.SetNumberEditorRange( 0, 100 );
        textLabel6.SetNumberEditorInterval( 1 );
        textLabel6.SetNumberEditorUsesMouseWheel( false );
        textLabel6.SetHasCustomTextHoverColor( false );
        textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel6.SetFont( "<Sans-Serif>", 14, true, false );

        textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "IIR" );
        AddComponent( textLabel7 );
        textLabel7.SetWantsMouseNotifications( false );
        textLabel7.SetPosition( 0, 139 );
        textLabel7.SetSize( 30, 24 );
        textLabel7.SetEditable( false, false );
        textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel7.SetBorderSize( 1 );
        textLabel7.SetMultiLineEdit( false );
        textLabel7.SetIsNumberEditor( false );
        textLabel7.SetNumberEditorRange( 0, 100 );
        textLabel7.SetNumberEditorInterval( 1 );
        textLabel7.SetNumberEditorUsesMouseWheel( false );
        textLabel7.SetHasCustomTextHoverColor( false );
        textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel7.SetFont( "<Sans-Serif>", 10, true, false );

        textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "FIR" );
        AddComponent( textLabel8 );
        textLabel8.SetWantsMouseNotifications( false );
        textLabel8.SetPosition( 56, 138 );
        textLabel8.SetSize( 30, 24 );
        textLabel8.SetEditable( false, false );
        textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel8.SetBorderSize( 1 );
        textLabel8.SetMultiLineEdit( false );
        textLabel8.SetIsNumberEditor( false );
        textLabel8.SetNumberEditorRange( 0, 100 );
        textLabel8.SetNumberEditorInterval( 1 );
        textLabel8.SetNumberEditorUsesMouseWheel( false );
        textLabel8.SetHasCustomTextHoverColor( false );
        textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel8.SetFont( "<Sans-Serif>", 10, true, false );

        textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "IN" );
        AddComponent( textLabel2 );
        textLabel2.SetWantsMouseNotifications( false );
        textLabel2.SetPosition( 2, 221 );
        textLabel2.SetSize( 80, 30 );
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
        textLabel2.SetFont( "<Sans-Serif>", 14, true, false );

        textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "DRIVE" );
        AddComponent( textLabel5 );
        textLabel5.SetWantsMouseNotifications( false );
        textLabel5.SetPosition( 3, 159 );
        textLabel5.SetSize( 80, 30 );
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
        textLabel5.SetFont( "<Sans-Serif>", 14, true, false );

        textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "OVER SAMPLING HARDCLIP TEMPLATE" );
        AddComponent( textLabel3 );
        textLabel3.SetWantsMouseNotifications( false );
        textLabel3.SetPosition( 3, 0 );
        textLabel3.SetSize( 80, 62 );
        textLabel3.SetEditable( false, false );
        textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
        textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
        textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
        textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
        textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
        textLabel3.SetBorderSize( 1 );
        textLabel3.SetMultiLineEdit( true );
        textLabel3.SetIsNumberEditor( false );
        textLabel3.SetNumberEditorRange( 0, 100 );
        textLabel3.SetNumberEditorInterval( 1 );
        textLabel3.SetNumberEditorUsesMouseWheel( false );
        textLabel3.SetHasCustomTextHoverColor( false );
        textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
        textLabel3.SetFont( "Arial", 14, true, false );

        textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "OUT" );
        AddComponent( textLabel4 );
        textLabel4.SetWantsMouseNotifications( false );
        textLabel4.SetPosition( 2, 291 );
        textLabel4.SetSize( 80, 30 );
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
        textLabel4.SetFont( "<Sans-Serif>", 14, true, false );

        driveKnob = new VoltageKnob( "driveKnob", "Drive", this, 1.0, 8, 1.0 );
        AddComponent( driveKnob );
        driveKnob.SetWantsMouseNotifications( false );
        driveKnob.SetPosition( 29, 188 );
        driveKnob.SetSize( 27, 27 );
        driveKnob.SetSkin( "Plastic White" );
        driveKnob.SetRange( 1.0, 8, 1.0, false, 0 );
        driveKnob.SetKnobParams( 215, 145 );
        driveKnob.DisplayValueInPercent( false );
        driveKnob.SetKnobAdjustsRing( true );
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


        m_drive         = new SmoothValue();
        m_processor     = new HardClipProcessor();
        m_oversampler   = new R_IIR_Oversampler( Values.SampleRate, 2, 20e3 );

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
                if( component == driveKnob )
                {
                    m_drive.SetValue( doubleValue );
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
                    m_osFactor =  (int)doubleValue;
                    initOversampler();
                    return true;
                }
                if( component == osTypeSwitch )
                {
                    m_type = OS_TYPE.values()[(int)doubleValue];
                    initOversampler();
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
        double value = 0.2 * in.GetValue();

        value *= m_drive.GetSmoothValue();

        value = m_oversampler.process( value, m_processor );

        out.SetValue( 5.0 * value );

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

        if( component == osFactorSwitch )
        {
            switch( (int)osFactorSwitch.GetValue() )
            {
                case 0:
                    return "NO Oversampling";
                case 1:
                    return "2x Oversampling";
                case 2:
                    return "4x Oversampling";
                case 3:
                    return "8x Oversampling";
                case 4:
                    return "16x Oversampling";
            }
        }

        if( component == osTypeSwitch )
        {
            return m_type.toString();
        }

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
    private VoltageKnob driveKnob;
    private VoltageLabel textLabel4;
    private VoltageLabel textLabel3;
    private VoltageLabel textLabel5;
    private VoltageLabel textLabel2;
    private VoltageLabel textLabel8;
    private VoltageLabel textLabel7;
    private VoltageLabel textLabel6;
    private VoltageLabel textLabel1;
    private VoltageSwitch osTypeSwitch;
    private VoltageSwitch osFactorSwitch;
    private VoltageAudioJack out;
    private VoltageAudioJack in;


    //[user-code-and-variables]    Add your own variables and functions here
    private class HardClipProcessor implements R_IOversampledProcessor
    {
        public HardClipProcessor()
        {
        }

        public double process( double value )
        {
            return 0.5 * ( Math.abs( value + 1 ) - Math.abs( value - 1 ) );
        }
    }

    private void initOversampler()
    {
        /* note:
         * in a real product you need to ensure that switching the oversampler
         * is synchronized with your processing function by e.g. locking it for
         * the time the oversampler is being instantiated.
         * be especially careful with higher order FIR oversamplers that need to
         * allocate huge amounts of memory for the coefficients. this may take
         * longer than the processing function can wait for.
         */
        if( m_osFactor == 0 )
        {
            m_oversampler = new R_NO_Oversampler( Values.SampleRate, 0 );
        }
        else
        {
            int osFactor = 1 << m_osFactor;
            if( m_type == OS_TYPE.IIR )
            {
                m_oversampler = new R_IIR_Oversampler( Values.SampleRate, osFactor, 20e3 );
            }
            else if( m_type == OS_TYPE.FIR )
            {
                m_oversampler = new R_FIR_Oversampler(
                        R_FIR_Coeffs_Kaiser_20_24_100.getCoeffs( osFactor )
                        );
            }
        }
    }

    private enum OS_TYPE
    {
        IIR,
        FIR,
    }

    private OS_TYPE             m_type = OS_TYPE.IIR;
    private int                 m_osFactor;
    private SmoothValue         m_drive;
    private HardClipProcessor   m_processor;
    private R_IOversampler      m_oversampler;
    //[/user-code-and-variables]
}

 
